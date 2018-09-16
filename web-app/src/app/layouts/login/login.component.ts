import { Component, OnInit } from '@angular/core';
import { Router, ActivatedRoute } from '@angular/router';
import { routerTransition } from '../../router.animations';
import { CommonService, AuthenticationService } from '../../shared/services';
import { FormGroup, FormBuilder, Validators } from '@angular/forms';
import { User } from '../../core/model/users';
import { first } from 'rxjs/operators';
import { AlertService } from '../../shared/alert/alert.service';

@Component({
    selector: 'app-login',
    templateUrl: './login.component.html',
    styleUrls: ['./login.component.scss'],
    animations: [routerTransition()]
})
export class LoginComponent implements OnInit {
    webTitle = '';
    loginForm: FormGroup;
    returnUrl: string;


    constructor(
        public router: Router,
        private commonService: CommonService,
        private fb: FormBuilder,
        private route: ActivatedRoute,
        private authenService: AuthenticationService,
        private alert: AlertService
    ) {
        this.webTitle = this.commonService.getWebTile();
    }

    ngOnInit() {
        this.returnUrl = this.route.snapshot.queryParams['returnUrl'] || '/';
        this.buildLoginForm();
    }

    buildLoginForm() {
        this.loginForm = this.fb.group({
            username: ['', [
                Validators.maxLength(25),
                Validators.minLength(5),
                Validators.required
            ]],
            password: ['', Validators.compose([
                Validators.minLength(5),
                Validators.required
            ])],
        });
    }

    login(form: FormGroup) {
        const username = form.value.username;
        const password = form.value.password;
        const user: User = new User(username, password, '', '');
        this.alert.error('Thông tin đăng nhập không chính xác.');
        this.authenService.login(user).pipe(first()).subscribe(data => {
            this.alert.error('Thông tin đăng nhập không chính xác.');
            this.router.navigate([this.returnUrl]);
        }, error => {
            this.alert.error('Thông tin đăng nhập không chính xác.');
        });
    }
}
