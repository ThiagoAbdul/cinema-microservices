const unitService = require('../service/unitService')

async function addUnit(req, res){
    const unit = req.body
    if (unit){
        try{
            const saved = await unitService.addUnit(unit)
            return res.status(201).json(saved)
        }
        catch(error){
            return res.status(400).json({
                message: error.message
            })
        }
    }
    return res.status(400).json({
        message: 'Unexpected error'
    })

}

async function listAll(_, res){
    try{
        const units = await unitService.findAll()
        return res.json(units)
    }
    catch(error){
        return res.status(400).json({}) // TODO
    }
}

module.exports = { addUnit, listAll }