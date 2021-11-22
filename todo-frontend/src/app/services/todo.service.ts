import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { FormBuilder } from '@angular/forms';
import { Observable } from 'rxjs';
import { environment } from 'src/environments/environment';
import { ITodoItem } from '../models/ITodoItem';

@Injectable({
  providedIn: 'root'
})
export class TodoService {

  private apiUrl = `${environment.baseApiUrl}/api/v1`;

  constructor(private http: HttpClient) { }

  getTodos(): Observable<ITodoItem[]> {
    return this.http.get<ITodoItem[]>(`${this.apiUrl}/todos`);
  }

  createTodo(desc: string)  {
    return this.http.post(`${this.apiUrl}/todos`, {description: desc});
  }

  updateTodo(todo: ITodoItem) {
    return this.http.put(`${this.apiUrl}/todos/${todo.id}`, 
    {id: todo.id, description: todo.description, completed: todo.completed});
  }

  deleteTodo(id: number) {
    return this.http.delete(`${this.apiUrl}/todos/${id}`);
  }
}
