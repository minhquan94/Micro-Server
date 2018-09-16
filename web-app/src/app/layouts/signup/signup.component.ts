import { Component, OnInit } from '@angular/core';
import { routerTransition } from '../../router.animations';
import { CommonService, AuthenticationService } from '../../shared/services';
import { FormGroup, FormBuilder, Validators } from '@angular/forms';
import { Router, ActivatedRoute } from '@angular/router';
import { AlertService } from '../../shared/alert/alert.service';
import { User } from '../../core/model/users';
import { first } from 'rxjs/operators';

@Component({
    selector: 'app-signup',
    templateUrl: './signup.component.html',
    styleUrls: ['./signup.component.scss'],
    animations: [routerTransition()]
})
export class SignupComponent implements OnInit {

    webTitle = '';
    passwordNotMatch = true;
    signupForm: FormGroup;
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
        this.signupForm = this.fb.group({
            fullName: ['', [Validators.required]],
            email: ['', [
                Validators.required,
                Validators.email]],
            username: ['', [
                Validators.maxLength(25),
                Validators.minLength(5),
                Validators.required
            ]],
            password: ['', Validators.compose([
                Validators.minLength(5),
                Validators.required
            ])],
            repeatPassword: ['', Validators.required]
        });
    }

    signup(form: FormGroup) {
        const fullName = form.value.password;
        const email = form.value.password;
        const username = form.value.username;
        const password = form.value.password;
        const repeatPassword = form.value.repeatPassword;
        if (password.value !== repeatPassword.value) {
            this.alert.error('Password does not match');
            return;
        }

        const user: User = new User(username, password, '', '');
        this.authenService.login(user).pipe(first()).subscribe(data => {
            this.router.navigate([this.returnUrl]);
        }, error => {
            this.alert.error('Thông tin đăng nhập không chính xác.');
        });
    }

    matchingPasswords(passwordKey: string, confirmPasswordKey: string) {
        return (group: FormGroup): { [key: string]: any } => {
            const password = group.controls[passwordKey];
            const confirmPassword = group.controls[confirmPasswordKey];

            if (password.value !== confirmPassword.value) {
                return {
                    mismatchedPasswords: true
                };
            }
        };
    }
}
