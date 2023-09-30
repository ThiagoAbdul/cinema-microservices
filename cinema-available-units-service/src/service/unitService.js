const Shop = require('../model/Shop')

async function addUnit(unit){
    if(isUnit(unit)){
        return await Shop.create(unit)
    }
    throw new Error('Error on shop input')
}

function isUnit(unit){
    return true; // TODO
}

async function findAll(){
    return await Shop.findAll()
}

async function findByName(name){
    return await Shop.findOne({
        where: {
            name
        }
    })
}

module.exports = { addUnit, isUnit, findAll, findByName }