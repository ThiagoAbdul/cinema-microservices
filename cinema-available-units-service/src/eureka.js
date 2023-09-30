const server = require('./server');

const Eureka = require('eureka-js-client').Eureka

const port = process.env.API_PORT || 8000

const eurekaClient = new Eureka({
    // application instance information
    instance: {
      app: 'available-units-service',
      hostName: 'localhost',
      ipAddr: '127.0.0.1',
      statusPageUrl: `http://localhost:${port}/api/available-units/health`,
      port: {
        '$': port,
        '@enabled': true
      },
      vipAddress: 'available-units-service',
      dataCenterInfo: {
        '@class': 'com.netflix.appinfo.InstanceInfo$DefaultDataCenterInfo',
        name: 'MyOwn',
      },
    },
    eureka: {
      host: process.env.EUREKA_HOST,
      port: process.env.EUREKA_PORT,
      servicePath: '/eureka/apps/',
      maxRetries: 10,
      requestRetryDelay: 2000,
    },
  });

  eurekaClient.logger.level('debug')

  module.exports = eurekaClient
