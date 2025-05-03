# receipt-processor
Spring boot app to calculate the points 

HERE ARE THE STEPS TO RUN 
1)Mvn clean package - to generate the jar for receipt processor
2)docker build -t receipt-processor .  - to build docker image for receipt processor
3) docker-compose up --build  -  to run all services (receipt processor and postgres)

Tested the app with post call and get call

4) Here is the curl for post call
curl --location --request POST 'http://localhost:8080/receipts/process' \
--header 'Content-Type: application/json' \
--data-raw '{
  "retailer": "M&M Corner Market",
  "purchaseDate": "2022-03-20",
  "purchaseTime": "14:33",
  "items": [
    {
      "shortDescription": "Gatorade",
      "price": "2.25"
    },{
      "shortDescription": "Gatorade",
      "price": "2.25"
    },{
      "shortDescription": "Gatorade",
      "price": "2.25"
    },{
      "shortDescription": "Gatorade",
      "price": "2.25"
    }
  ],
  "total": "9.00"
}'


5) Here is the curl for Get call

curl --location --request GET 'http://localhost:8080/receipts/fcdf1f9c-94f4-4b9f-ac8c-5cb6c8f5d1e3/points'
![image](https://github.com/user-attachments/assets/85126d93-a0a4-4e1e-8cf1-9d0ff0b5b89a)

