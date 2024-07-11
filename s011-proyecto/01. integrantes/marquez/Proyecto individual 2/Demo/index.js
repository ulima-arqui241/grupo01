const express = require("express");
const app = express();
const port = 3000;

app.use(express.json())

app.post("/count", (req, res) => {
  const counts = req.body.counts;

  var count = 0

  for (let i = 0; i < (counts || 1); i++) {
    count += 1
  }

  res.send(`Counted to ${count}`);
});

app.get("/", (req, res) => {
  res.send(`Hi`);
});

app.listen(port, () => {
  console.log(`Servidor escuchando en http://localhost:${port}`);
});
