const db = require('../db')
const Shop = require('./Shop')
const Movie = require('./Movie')

const MovieShop = db.define('movie_shop', {})

Shop.belongsToMany(Movie, { through: 'movie_shop' })
Movie.belongsToMany(Shop, {through: 'movie_shop'})

module.exports = MovieShop