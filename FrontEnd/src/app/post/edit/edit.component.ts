import { Component, OnInit } from '@angular/core';
import { FormControl, FormGroup, Validators } from '@angular/forms';
import { ActivatedRoute, Router } from '@angular/router';
import { PostService } from '../post.service';
import { User } from '../User';

@Component({
  selector: 'app-edit',
  templateUrl: './edit.component.html',
  styleUrls: ['./edit.component.css']
})
export class EditComponent implements OnInit {

  id: number
  user: User;
  form: FormGroup

  constructor(private userService: PostService, private activatedRoute: ActivatedRoute, private router: Router) { }

  ngOnInit(): void {
    // console.log(this.activatedRoute.queryParams)
    this.id = this.activatedRoute.snapshot.params.userId
    console.log(this.id);
    this.userService.find(this.id).subscribe((data: User) => {
      this.user = data;
    this.patchFormData(data)
    });

    
    console.log('User Data', this.user)
    
    this.form = new FormGroup({
      id: new FormControl('', [Validators.required]),
      name: new FormControl('', [Validators.required]),
      email: new FormControl('', [Validators.required]),
      password: new FormControl('', Validators.required)
    });
  }

  patchFormData(user:User){
    this.form.patchValue({
      id: user.id,
      name: user.name,
      email: user.email,
      password: user.password
    })
  }

  get f() {
    return this.form.controls;
  }

  submit() {
    console.log(this.form.value)
    this.userService.update(this.id, this.form.value).subscribe(res => {
      console.log('User Updated Successfully');
      this.router.navigateByUrl('index')
    })
  }
}
