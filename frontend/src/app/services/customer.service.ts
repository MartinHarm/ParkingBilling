import { Injectable } from '@angular/core';
import {HttpClient, HttpHeaders} from '@angular/common/http';
import {Observable, throwError} from 'rxjs';
import { Customer } from '../models/customer.model';
import {CustomerReport} from "../models/customer-report.model";

const baseUrl = 'http://localhost:8081/api/customers';

@Injectable({
  providedIn: 'root'
})
export class CustomerService {

  constructor(private http: HttpClient) { }

  getAll(): Observable<Customer[]> {
    return this.http.get<Customer[]>('https://localhost:8443/customer', { headers: {
       "Authorization": "Basic " + btoa(  "user:user" )
      }});
  }

  generatePdfInvoice(customerId: number): void {
    window.location.assign(`https://localhost:8443/invoice/generate/${customerId}`);
  }

  getCustomerReport(customerId: number): Observable<CustomerReport> {
    return this.http.get<CustomerReport>(`https://localhost:8443/report/${customerId}`, { headers: {
        "Authorization": "Basic " + btoa(  "user:user" )
      }});
  }
}
