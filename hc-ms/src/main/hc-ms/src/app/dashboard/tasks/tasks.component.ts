import { Component, OnInit, ViewChild } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { LoaderComponent } from 'src/app/loader/loader.component';
import { ApiService } from 'src/app/services/api/api.service';
import { BotService } from 'src/app/services/notification-bot/bot.service';


@Component({
  selector: 'app-tasks',
  templateUrl: './tasks.component.html',
  styleUrls: ['./tasks.component.css']
})
export class TasksComponent implements OnInit {

  constructor(private formBuilder: FormBuilder, private api: ApiService, private bot: BotService) { 
  }

  @ViewChild(LoaderComponent, { static: true })
  private loader: LoaderComponent;

  taskName:string = "";
  employeeId:string = "";

  ngOnInit() {
    this.list();
    this.listEmployees();
  }

  funds:any[] = [];
  employees:any[]=[];
  form: FormGroup;

  listEmployees(){
    this.loader.load();
    this.api.listEmployee().subscribe(response => {
      this.loader.resume();
      this.api.validateResponse(response, data => {
        this.employees = data;
      }, error => {
        this.bot.fail(error);
      });
    });
  }

  list(){
    this.loader.load();
    this.api.listTasks().subscribe(response => {
      this.loader.resume();
      this.api.validateResponse(response, data => {
        this.funds = data;
      }, error => {
        this.bot.fail(error);
      });
    });
  }

  validateAndAdd(){
    let tasks:any = {};
    tasks.taskName = this.taskName;
    tasks.employee = {
      employeeId: this.employeeId
    };
    this.loader.load();
    this.api.addTask(tasks).subscribe(response => {
      this.loader.resume();
      this.api.validateResponse(response, data=>{
        this.funds.push(data);
        this.form.reset();
        this.bot.success("Task Added!");
      }, error=>{
        this.bot.fail(error);
      })
    });
  }

}
