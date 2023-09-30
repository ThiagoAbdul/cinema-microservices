const db = require('../db')
const Sequelize = require('sequelize')

const Shop = db.define('shop', {
    id: {
        type: Sequelize.UUID,
        primaryKey: true,
        defaultValue: Sequelize.UUIDV4
    },
    name: {
        type: Sequelize.STRING(40),
        allowNull: false,
    },
    cep: {
        type: Sequelize.STRING(9),
        allowNull: false
    }
})

module.exports = Shop