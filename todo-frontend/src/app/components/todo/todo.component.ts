import { THIS_EXPR } from '@angular/compiler/src/output/output_ast';
import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup } from '@angular/forms';
import { NgbModal } from '@ng-bootstrap/ng-bootstrap';
import { ITodoItem } from 'src/app/models/ITodoItem';
import { TodoService } from 'src/app/services/todo.service';

@Component({
  selector: 'app-todo',
  templateUrl: './todo.component.html',
  styleUrls: ['./todo.component.css']
})
export class TodoComponent implements OnInit {

  todoList: ITodoItem[] = [];
  newTodoTextbox: string = '';

  constructor(
    private todoService: TodoService,
    private modalService: NgbModal
  ) {

  }

  ngOnInit(): void {
    this.getTodoList();
  }

  getTodoList() {
    this.todoService.getTodos().subscribe(
      (todoList: ITodoItem[]) => {
        this.todoList = todoList;
        console.log(this.todoList);

      }
    )
  }

  addTodo(todo: string) {
    this.todoService.createTodo(todo).subscribe(
      (todoItem: any) => {
        this.getTodoList();

      }
    );
    this.newTodoTextbox = '';
  }

  open(content: any, todoItem: ITodoItem) {
    this.modalService.open(content, { ariaLabelledBy: 'modal-basic-title' }).result.then((result) => {
      console.log("selected: " + todoItem.id);
      todoItem.description = result;
      this.updateTodo(todoItem);
      this.getTodoList();
    }, (reason) => {
      console.log(reason);
    }
    );
  }

  updateTodo(todoItem: ITodoItem) {
    this.todoService.updateTodo(todoItem).subscribe(
      (todoItem: any) => {
        this.getTodoList();
        console.log(todoItem);
      }
    );
  }

  deleteTodo(todoItem: ITodoItem) {
    this.todoService.deleteTodo(todoItem.id).subscribe(
      (todoItem: any) => {
        this.getTodoList();
        console.log(todoItem);
      }
    );
  }
}
