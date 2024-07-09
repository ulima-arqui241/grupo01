let mongoose = require("mongoose");

class Database {
  constructor() {
    this.connect();
  }

  connect() {
    const url = process.env.MONGODB_URL;
    mongoose
      .connect(url || "urlRandom")
      .then(() => {
        console.log("Database connection successful");
      })
      .catch((err) => {
        console.error("Database connection error");
      });
  }

  checkStatus() {
    const status = mongoose.connection.readyState
    return status
  }
}

module.exports = new Database();
