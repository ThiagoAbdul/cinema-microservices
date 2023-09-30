const Movie = require("../model/Movie")
const Shop = require("../model/Shop")
const MovieShop = require('../model/MovieShop')
const unitService = require('./unitService')
const db = require('../db')
const { QueryTypes } = require("sequelize")


async function findUnitsByMovieId(id){
    const sql = 'SELECT * FROM shops JOIN movie_shops ON shops.id = "movie_shops"."shopId" WHERE "movie_shops"."movieId" = ?'
    const result = await db.query(sql, {
        replacements: [id],
        type: QueryTypes.SELECT
    })
    return result

}

function isMovie({title, releaseYear}){
    return title != undefined && releaseYear != undefined 
}



async function addMovieToUnit(movie, unitId){
    const transaction = await db.transaction()
    try{
        if(isMovie(movie) && unitId){
            const foundUnit = await Shop.findByPk(unitId)
            let movieToAdd = await Movie.findByPk(movie.id)
            if(movieToAdd == null){
                movieToAdd = await Movie.create(movie)
            }
            await movieToAdd.addShop(foundUnit)
            transaction.commit()
            return movieToAdd
        }
    }
    catch(error){
        transaction.rollback()
        console.log(error)
    }
    return false
}

module.exports = { findUnitsByMovieId, addMovieToUnit }