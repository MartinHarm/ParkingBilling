import {Customer} from "./customer.model";

export class CustomerReport {
  id?: any;
  customer?: Customer;
  customerId?: number;
  reportRows?: ReportRow[];
  invoiceTotal?:number;
  invoiceTotalWithTax?: number;
  exceedsMaximumInvoice?: boolean;
}

export class ReportRow {
  id?: any;
  regNumber?: string;
  parkingStarted?: string;
  parkingEnded?: string[];
  facility?:string;
  cost?: number;
  reportId?: number;
}
