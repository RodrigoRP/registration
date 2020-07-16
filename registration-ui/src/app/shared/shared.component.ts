import { Component, OnInit } from '@angular/core';
import { Router, ActivatedRoute } from '@angular/router';
import { Person } from '../person';
import { PersonService } from '../../../service/person.service';


@Component({
  selector: 'app-shared',
  templateUrl: './shared.component.html',
  styleUrls: ['./shared.component.css']
})
export class SharedComponent implements OnInit {

  id: number;
  person: Person;

  constructor(private route: ActivatedRoute,private router: Router,
    private personService: PersonService) { }

  ngOnInit() {
    this.person = new Person();

    this.id = this.route.snapshot.params['id'];
    
    this.personService.getPerson(this.id)
      .subscribe(data => {
        console.log(data)
        this.person = data;
      }, error => console.log(error));
  }

  list(){
    this.router.navigate(['persons']);
  }

  createPerson(){
    this.router.navigate(['add']);
  }
}
