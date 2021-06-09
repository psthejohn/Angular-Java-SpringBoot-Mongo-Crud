import { Component, OnInit } from '@angular/core';
import { PostService } from '../post.service';
import { User } from '../User';

@Component({
  selector: 'app-index',
  templateUrl: './index.component.html',
  styleUrls: ['./index.component.css']
})
export class IndexComponent implements OnInit {

  users: User[] = [];

  constructor(public userService: PostService) { }

  ngOnInit(): void {
    this.userService.getAll().subscribe((data: User[]) => {
      this.users = data;
    })
  }

  deleteUser(id: number) {
    this.userService.delete(id).subscribe(res => {
      this.users = this.users.filter(item => item.id !== id);
      console.log('Post deleted successfully!');
    })
  }
}
