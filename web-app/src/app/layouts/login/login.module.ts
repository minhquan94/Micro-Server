import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { LoginRoutingModule } from './login-routing.module';
import { LoginComponent } from './login.component';
import { CommonService, AuthenticationService } from '../../shared/services';
import { ReactiveFormsModule } from '@angular/forms';
import { AlertService } from '../../shared/alert/alert.service';
import { AlertModule } from '../../shared';

@NgModule({
    imports: [
        CommonModule,
        ReactiveFormsModule,
        LoginRoutingModule],
    declarations: [LoginComponent],
    providers: [CommonService, AuthenticationService]
})
export class LoginModule { }
