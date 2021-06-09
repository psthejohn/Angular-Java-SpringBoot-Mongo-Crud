import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { PostService } from '../post.service';
import { User } from '../User';

@Component({
  selector: 'app-view',
  templateUrl: './view.component.html',
  styleUrls: ['./view.component.css']
})
export class ViewComponent implements OnInit {

  id: number;
  user: User;

  constructor(public userService: PostService, private route: ActivatedRoute, private router: Router
  ) { }

  ngOnInit(): void {
    this.id = this.route.snapshot.params['userId'];
    this.userService.find(this.id).subscribe((data: User) => {
      this.user = data;
    });
  }
}