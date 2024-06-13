const express = require("express");
const app = express();
const port = process.env.HEALTH_PORT || 4000;
const baseUrl = process.env.ENDPOINT_URL || `http://localhost:${4000}/`;

app.listen(port, () => {
  console.log(`Example app listening on port ${port}`);
});

app.get("/", async (req, res) => {
  try {
    const startHealthTimeCheck = process.hrtime();
    const response = await fetch(`${baseUrl}healthCheck`);
    const endHealthTimeCheck = process.hrtime(startHealthTimeCheck);
    const availabilityStatus = response.status;
    const availableData = await response.json();
    const availabilityData = {
      status: availabilityStatus,
      responseTime: endHealthTimeCheck[1] / 1_000_000,
      data: availableData,
    };

    const startDBTime = process.hrtime();
    const dbResponse = await fetch(`${baseUrl}databaseCheck`);
    const endDBTime = process.hrtime(startDBTime);
    const dbStatusCode = dbResponse.status;
    const dbData = await dbResponse.json();
    const databaseData = {
      status: dbStatusCode,
      responseTime: endDBTime[1] / 1_000_000,
      data: dbData,
    };

    res.send({
      healthCheck: availabilityData,
      databaseCheck: databaseData,
    });
  } catch  {
    res.status(500).send({
      status: 500,
      message: "Endpoint is not live"
    })
  }
  
});
