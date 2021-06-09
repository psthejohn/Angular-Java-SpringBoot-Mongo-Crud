import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';

const routes: Routes = [
  { path: '', redirectTo: 'post', pathMatch: 'full' },
  { path: 'post', loadChildren: () => import("./post/post.module").then(m => m.PostModule) }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }


// {
//   path: '',
//   redirectTo: '/dashboard',
//   pathMatch: 'full'
// },
// {
//   path: 'dashboard',
//   component: DashboardLayoutComponent, // DashboardLayoutComponent
//   canActivate: [AuthGuard], // Should be replaced with actual auth guard
//   children: [
//     {
//       path: '',
//       loadChildren: () =>
//         import('./modules/dashboard/dashboard.module').then(m => m.DashboardModule)
//     }
//   ]
// }