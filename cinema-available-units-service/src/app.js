require('dotenv').config()
const server = require('./server')
const db = require('./db')
const eurekaClient = require('./eureka')

const port = process.env.API_PORT

db.sync().then(() => {
    server.listen(port, () => console.log(`Server in running at http://localhost:${port}/`))
})

eurekaClient.start(error => {
    console.log(error || "user service registered")
})

