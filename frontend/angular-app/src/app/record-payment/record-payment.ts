import { Component, inject, output, signal } from '@angular/core';
import { Payment } from '../payments/payment';
import { form, FormField } from '@angular/forms/signals';
import { FormsModule } from '@angular/forms';
import { PaymentService } from '../payments/payments.service';

@Component({
  imports: [FormsModule, FormField],
  selector: 'app-record-payment',
  styleUrl: './record-payment.css',
  templateUrl: './record-payment.html',
})
export class RecordPayment {
  paymentCreated = output<void>();
  categories = [
    '',
    'Food',
    'Transportation',
    'Housing',
    'Entertainment',
    'Shopping',
    'Utilities',
    'Healthcare',
    'Other',
  ];
  private paymentService = inject(PaymentService);
  paymentModel = signal<Omit<Payment, 'id' | 'updatedDate' | 'createdDate'>>({
    amount: 0,
    category: '',
    description: '',
    payee: '',
    paymentDate: '',
  });
  paymentForm = form(this.paymentModel);

  submitPayment() {
    this.paymentService.createPayment(this.paymentModel()).subscribe({
      next: (response) => {
        console.log('Payment created:', response);
        // Alert Payment component - refetch all payments after this payment is posted.
        this.paymentCreated.emit();
      },
      error: (error) => {
        console.error('Failed to create payment:', error);
      },
    });
  }
}
