package ee.parking.parkingbillingapp.usecase.report.model;

import ee.parking.parkingbillingapp.customer.model.Customer;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.List;

@Entity
public class Report {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @JoinColumn(name = "customer_id", insertable = false, updatable = false)
    @ManyToOne(targetEntity = Customer.class, fetch = FetchType.EAGER)
    private Customer customer;

    @Column(name = "customer_id")
    private Long customerId;

    @JoinColumn(name = "report_id", insertable = false, updatable = false)
    @OneToMany(targetEntity = ReportRow.class, fetch = FetchType.EAGER)
    private List<ReportRow> reportRows;

    private BigDecimal invoiceTotal;

    private BigDecimal invoiceTotalWithTax;

    @Transient
    private Boolean exceedsMaximumInvoice = false;

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public BigDecimal getInvoiceTotal() {
        return invoiceTotal;
    }

    public void setInvoiceTotal(BigDecimal invoiceTotal) {
        this.invoiceTotal = invoiceTotal;
    }

    public BigDecimal getInvoiceTotalWithTax() {
        return invoiceTotalWithTax;
    }

    public void setInvoiceTotalWithTax(BigDecimal invoiceTotalWithTax) {
        this.invoiceTotalWithTax = invoiceTotalWithTax;
    }

    public Long getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Long customerId) {
        this.customerId = customerId;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<ReportRow> getReportRows() {
        return reportRows;
    }

    public void setReportRows(List<ReportRow> reportRows) {
        this.reportRows = reportRows;
    }

    public Boolean getExceedsMaximumInvoice() {
        return exceedsMaximumInvoice;
    }

    public void setExceedsMaximumInvoice(Boolean exceedsMaximumInvoice) {
        this.exceedsMaximumInvoice = exceedsMaximumInvoice;
    }
}
