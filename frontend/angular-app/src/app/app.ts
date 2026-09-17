import { Component, signal } from '@angular/core';
import { RouterOutlet } from '@angular/router';
import { Payments } from './payments/payments';
import { RecordPayment } from './record-payment/record-payment';

@Component({
  imports: [RouterOutlet, Payments, RecordPayment],
  selector: 'app-root',
  styleUrl: './app.css',
  templateUrl: './app.html',
})
export class App {
  protected readonly title = signal('angular-app');
}
