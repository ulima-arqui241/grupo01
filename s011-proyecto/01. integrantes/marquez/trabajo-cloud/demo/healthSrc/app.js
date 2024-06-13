const express = require("express");
const app = express();
const port = process.env.HEALTH_PORT || 4000;
const baseUrl = process.env.ENDPOINT_URL || `http://localhost:${4000}/`;

app.listen(port, () => {
  console.log(`Example app listening on port ${port}`);
});

app.get("/", async (req, res) => {
  const startHealthTimeCheck = process.hrtime();
  const response = await fetch(`${baseUrl}healthCheck`);
  const endHealthTimeCheck = process.hrtime(startHealthTimeCheck);
  const availabilityStatus = response.status;
  const availableData = await response.json()

  const startDBTime = process.hrtime();
  const dbResponse = await fetch(`${baseUrl}databaseCheck`);
  const endDBTime = process.hrtime(startDBTime);
  const dbStatusCode = dbResponse.status;
  const dbData = await dbResponse.json()

  res.send({
    healthCheck: {
      responseTime: endHealthTimeCheck,
      status: availabilityStatus,
      data: availableData
    },
    databaseCheck: {
      responseTime: endDBTime,
      status: dbStatusCode,
      data: dbData
    },
  });
});
