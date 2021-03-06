import { ImballoDto } from './dto/imballo-dto';
import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class ImballoServiceService {

  private url = "http://localhost:8080"
  imballi: ImballoDto[] = [];
  imballo: ImballoDto = new ImballoDto();
  imballoMod: ImballoDto = new ImballoDto();

  constructor(private http: HttpClient) { }

  addImballo() {
    let o: Observable<ImballoDto[]> =
      this.http.post<ImballoDto[]>(this.url + "/add-imballo", this.imballoMod)
    o.subscribe(risp => { this.imballi = risp; })
  }

  lista(): ImballoDto[] {
    let o: Observable<ImballoDto[]> = this.http.get<ImballoDto[]>(this.url + "/list-imballo")
    o.subscribe(risp => { this.imballi = risp; })
    return this.imballi
  }

  findImballo(imballo: ImballoDto) {
    let o: Observable<ImballoDto[]> = this.http.post<ImballoDto[]>(this.url + "/find-by-descrizione-imballo", imballo)
    o.subscribe(risp => { this.imballi = risp; })


  }

  updateImballo(imballoMod: ImballoDto) {
    let o: Observable<ImballoDto> =
      this.http.post<ImballoDto>(this.url + "/update-imballo", imballoMod)
    o.subscribe(risp => { this.imballo = risp; })
  }

  removeImballo(id: number) {
    let o: Observable<ImballoDto> = this.http.get<ImballoDto>(this.url + '/delete-imballo/' + id)
    o.subscribe(risp => { this.imballo = risp; })
    return this.imballo;
  }

  // findImballoByCosto(imballo: ImballoDto) {
  //   let o: Observable<ImballoDto[]> = this.http.post<ImballoDto[]>(this.url + "/find-by-costo-imballo", imballo)
  //   o.subscribe(risp => { this.imballi = risp; })
  // }

}
