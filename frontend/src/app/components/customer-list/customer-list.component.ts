import { Component, OnInit } from '@angular/core';
import { Customer } from 'src/app/models/customer.model';
import { CustomerService } from 'src/app/services/customer.service';
import {CustomerReport} from "../../models/customer-report.model";

@Component({
  selector: 'app-customer-list',
  templateUrl: './customer-list.component.html',
  styleUrls: ['./customer-list.component.css']
})
export class CustomerListComponent implements OnInit {

  customers?: Customer[];
  currentCustomer: Customer = {};
  customerReport?:  CustomerReport;

  constructor(private customerService: CustomerService) { }

  ngOnInit(): void {
    this.retrieveCustomers();
  }

  retrieveCustomers(): void {
    this.customerService.getAll()
      .subscribe(
        data => {
          this.customers = data;
        },
        error => {
          console.log(error);
        });
  }



  setActiveCustomer(customer: Customer, index: number): void {
    this.currentCustomer = customer;
    this.customerService.getCustomerReport(1).subscribe(response => {
        this.customerReport = response;
      },
      error => {
        console.log(error);
      });
  }





  generateInvoice(customerId: number) {
    this.customerService.generatePdfInvoice(customerId)
  }

}
