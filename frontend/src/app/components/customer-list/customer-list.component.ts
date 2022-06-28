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
  name = '';
  displayedColumns: string[] = ['position', 'name', 'weight', 'symbol'];

  customerReport?:  CustomerReport;

  customer: Customer = {
    id: "1",
    firstName: "",
    lastName: "",

  };

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

    this.customerService.getCustomerReport(customer.id).subscribe(customerReport => {
      console.log(customerReport);
      this.customerReport = customerReport;
    })
  }



  generateInvoice(customerId: number) {
    this.customerService.generatePdfInvoice(customerId)
  };

}
