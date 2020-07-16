import { ConfirmationService } from 'primeng/api';
import { Component, OnInit } from '@angular/core';

import { Observable } from "rxjs";
import { PersonService } from "../../../service/person.service";
import { Person } from "../person";
import { Router } from '@angular/router';

@Component({
  selector: 'app-person-list',
  templateUrl: './person-list.component.html',
  styleUrls: ['./person-list.component.css']
})
export class PersonListComponent implements OnInit {

  persons: Observable<Person[]>;

  constructor(
    private personService: PersonService,
    private router: Router,
    private confirmation: ConfirmationService
    ) {}

  ngOnInit() {
    this.reloadData();
  }

  reloadData() {
    this.persons = this.personService.getPersonsList();
  }

  confirmDelete(id: number) {
    this.confirmation.confirm({
      message: 'Tem certeza que deseja excluir?',
      accept: () => {
        this.deletePerson(id);
      }
    });
  }

  deletePerson(id: number) {
    this.personService.deletePerson(id)
      .subscribe(
        data => {
          console.log(data);
          this.reloadData();
        },
        error => console.log(error));
  }

  personDetails(id: number){
    this.router.navigate(['details', id]);
  }

  createPerson(){
    this.router.navigate(['add']);
  }

  updatePerson(id: number) {
    this.router.navigate(['update', id]);
  }
}