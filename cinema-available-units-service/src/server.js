const Express = require('express')
const server = Express()
const router = require('./router')

server.use(Express.json())
server.use(router)

module.exports = server