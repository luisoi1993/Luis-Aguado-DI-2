import { Pipe, PipeTransform } from '@angular/core';

@Pipe({
  name: 'imagenes',
  standalone: false,
})
export class ImagenesPipe implements PipeTransform {

  transform(value: string, ...args: unknown[]): string {
    switch
    (value) {
      case 'baja':
        return 'https://cdn.pixabay.com/photo/2015/04/23/22/00/tree-736885_1280.jpg';
        break
      case 'media':
        return 'https://cdn.pixabay.com/photo/2015/04/23/22/00/tree-736885_1280.jpg';
        break
      case 'alta':
        return 'https://cdn.pixabay.com/photo/2015/04/23/22/00/tree-736885_1280.jpg';
        break
      default:
        return 'https://cdn.pixabay.com/photo/2015/04/23/22/00/tree-736885_1280.jpg';
        break;
    }
    
  }

}
