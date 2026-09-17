import { Component, inject, signal } from '@angular/core';
import { Payment } from '../payments/payment';
import { form, FormField } from '@angular/forms/signals';
import { HttpClient } from '@angular/common/http';
import { FormsModule } from '@angular/forms';

@Component({
  imports: [FormsModule, FormField],
  selector: 'app-record-payment',
  styleUrl: './record-payment.css',
  templateUrl: './record-payment.html',
})
export class RecordPayment {
  private http = inject(HttpClient);

  paymentModel = signal<Omit<Payment, 'id' | 'updatedDate' | 'createdDate'>>({
    amount: 0,
    category: '',
    description: '',
    payee: '',
    paymentDate: '',
  });

  paymentForm = form(this.paymentModel);

  submitPayment() {
    console.log('SUBMITTING', this.paymentModel());
    this.http.post('http://localhost:8080/payments', this.paymentModel()).subscribe({
      next: (response) => {
        console.log('Payment created:', response);
      },
      error: (error) => {
        console.error('Failed to create payment:', error);
      },
    });
  }
}
