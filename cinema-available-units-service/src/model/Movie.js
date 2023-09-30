const db = require('../db')
const Sequelize = require('sequelize')

const Movie = db.define('movie', {
    id: {
        type: Sequelize.UUID,
        primaryKey: true
    },
    title: {
        type: Sequelize.STRING(50),
        allowNull: false
    },
    releaseYear: {
        type: Sequelize.INTEGER,
        allowNull: false
    }
})

module.exports = Movie