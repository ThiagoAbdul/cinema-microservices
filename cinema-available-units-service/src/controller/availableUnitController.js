const availableUnitService = require('../service/availableUnitService')

async function findUnitsForMovie(req, res){
    const id = req.params.id
    if(id){
        try{
            const units = await availableUnitService.findUnitsByMovieId(id)
            return res.json(units)
        }
        catch(error){
            return res.status(400).json({
                message: "Server Unexpected error"
            })
        }
    }
    return res.status(400).json({
        message: "Body is missing"
    })
}

async function addMovieToUnit(req, res){
    const {movie, unitId} = req.body
    console.log(movie)
    console.log(unitId)
    if (movie && unitId){
        try{
            const result = await availableUnitService.addMovieToUnit(movie, unitId)
            if(result){
                return res.status(201).json(result)
            }
            return res.status(400).json({
                message: 'Error at add movie'
            })
        }
        catch(error){
            return res.status(400).json({})
        } 
    }
    return res.status(400).json({
        message: 'Error on request body'
    })
}

module.exports = { findUnitsForMovie, addMovieToUnit }