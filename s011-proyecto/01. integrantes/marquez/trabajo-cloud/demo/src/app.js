const express = require("express");
const app = express();
const port = process.env.ENDPOINT_PORT || 3000;
const database = require("./mongodb");
const teamMemberModel = require("./models/teamMember");

app.listen(port, () => {
  console.log(`Example app listening on port ${port}`);
});

app.get("/healthCheck", (req, res) => {
  res.status(200).send({
    status: "ok",
  });
});

app.get("/databaseCheck", async (req, res) => {
  const databaseStatus = database.checkStatus();

  if (databaseStatus === 0 || databaseStatus === 3) {
    res.status(404).send({
      status: databaseStatus,
      message: "Database cannot be reached",
    });
  } else {
    try {
      await insertBaseUser();

      res.send({
        status: databaseStatus,
        message: "Database available",
      });
    } catch {
      res.status(405).send({
        status: 4,
        message: "Unable to save data on database"
      })
    }
  }
});

app.get("/insertUser", async (req, res) => {
  try {
    let doc = await insertBaseUser();
    res.status(200).send({
      msg: "Created!",
      doc: doc,
    });
  } catch (error) {
    res.status(500).send({
      error: error,
    });
  }
});

app.get("/allUsers", (req, res) => {
  teamMemberModel
    .find()
    .exec()
    .then((docs) => res.send(docs))
    .catch((err) => {
      console.log(err);
      res.send("Error!");
    });
});

async function insertBaseUser() {
  let member = new teamMemberModel({
    name: "Franco Marquez",
    email: "20191218@aloe.ulima.edu.pe",
  });
  try {
    let doc = await member.save();
    return doc;
  } catch (error) {
    throw new Error(error);
  }
}
