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

  ngOnInit(): void {
    console.log('Payments component initialized');

    this.paymentService.getPayments().subscribe({
      next: (payments) => {
        console.log('Payments received:', payments);
        this.payments.set(payments);
      },
      error: (error) => {
        console.log('Failed to load payments.', error);
      },
    });
  }
}
