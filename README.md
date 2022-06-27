<h1>ParkingBillingApp</h1>

```
1. Start database
docker-compose up

2. Run the up gradle bootRun

3. Navigate to https://localhost:8443/ (selfsigned certificate)

4. Login with provided credentials

USERNAME: user
PASSWORD: user

5. Search for customer to see report

6. Click on generate invoice to generate PDF invoice.

```

Get Customers:
<br />
https://localhost:8443/customer
<p>
* Mari Maasikas (id:1, customerType:regular)
<br />
<br />
* Margus Vaarikas (id:2, customerType:premium)
<br />
<br />
* Toomas Tomat (id:3, customerType:premium)
<br />

POST parkingLog endpoint for vendor:
<br />
https://localhost:8443/parking/log
```
{
"parkingStarted": "2022-06-26 19:40:00",
"parkingEnded": "2022-08-26 20:35:00",
"regNumber": "511BXX"
}
```
GET PDF Invoice Generation endpoints:
<br />
https://localhost:8443/invoice/generate/1
<br />
https://localhost:8443/invoice/generate/2
<br />
https://localhost:8443/invoice/generate/3

GET customer parking reports:
<br />
https://localhost:8443/report/1
<br />
https://localhost:8443/report/2
<br />
https://localhost:8443/report/3
<p>

POST new customer endpoint
<br />
https://localhost:8443/customer

```
{
    "firstName": "Urmas",
    "lastName": "Tomat",
    "customerType": "PREMIUM"
}
```
