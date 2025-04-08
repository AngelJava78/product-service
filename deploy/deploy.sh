#!/bin/bash
echo "Deploy de la aplicación"
nohup java -jar target/product-service.jar &> /dev/null &