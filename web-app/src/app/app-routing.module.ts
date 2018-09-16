import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { AuthGuard } from './shared';

const routes: Routes = [
  { path: '', loadChildren: './layouts/layout.module#LayoutModule', canActivate: [AuthGuard] },
  { path: 'login', loadChildren: './layouts/login/login.module#LoginModule' },
  { path: 'signup', loadChildren: './layouts/signup/signup.module#SignupModule' },
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
