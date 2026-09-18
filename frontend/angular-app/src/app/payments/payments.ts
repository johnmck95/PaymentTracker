import { Component, signal } from '@angular/core';
import { Payment } from './payment';
import { PaymentService } from './payments.service';

@Component({
  imports: [],
  selector: 'app-payments',
  styleUrl: './payments.css',
  templateUrl: './payments.html',
})
export class Payments {
  payments = signal<Payment[]>([]);
  constructor(private paymentService: PaymentService) {}

  deletePayment(id: number) {
    console.log(`Delete payment with id: ${id}.`);
    this.paymentService.deletePayment(id).subscribe({
      next: () => {
        this.payments.update((payments) => payments.filter((payment) => payment.id !== id));
      },
      error: (error) => {
        console.error(`Failed to delete payment ${id}.`, error);
      },
    });
  }

  ngOnInit(): void {
    this.paymentService.getPayments().subscribe({
      next: (payments) => {
        this.payments.set(payments);
      },
      error: (error) => {
        console.log('Failed to load payments.', error);
      },
    });
  }
}
