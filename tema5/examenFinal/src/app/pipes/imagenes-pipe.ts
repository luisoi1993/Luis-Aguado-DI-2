import { Pipe, PipeTransform } from '@angular/core';

@Pipe({
  name: 'imagenes',
  standalone: false,
})
export class ImagenesPipe implements PipeTransform {
  transform(value: number): string {
    if (value < 150) {
      return 'https://cdn-icons-png.flaticon.com/512/1945/1945940.png';
    }
    if (value < 250) {
      return 'https://cdn-icons-png.flaticon.com/512/8832/8832880.png';
    }
    if (value < 400) {
      return 'https://cdn-icons-png.flaticon.com/512/3145/3145765.png';
    }
    return 'https://cdn-icons-png.flaticon.com/512/2232/2232688.png';
  }
}
