const { Sequelize } = require("sequelize");

const user = process.env.PGUSER
const password = process.env.PGPASSWORD
const host = process.env.PGHOST
const port = process.env.PGPORT

const sequelize = new Sequelize(
    `postgres://${user}:${password}@${host}:${port}/available_unit_service_db`)

module.exports = sequelize