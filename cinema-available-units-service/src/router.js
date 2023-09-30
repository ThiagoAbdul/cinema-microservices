const router = require('express').Router()
const availableUnitController = require('./controller/availableUnitController')
const unitController = require('./controller/unitController')

router.post('/api/available-units/units', unitController.addUnit)
router.get('/api/available-units/units', unitController.listAll)
router.post('/api/available-units/movie', availableUnitController.addMovieToUnit)
router.get('/api/available-units/movie/:id', availableUnitController.findUnitsForMovie)
router.get('/api/available-units/health', (_, res) => res.status(200).json({status: 'OK'}))

module.exports = router