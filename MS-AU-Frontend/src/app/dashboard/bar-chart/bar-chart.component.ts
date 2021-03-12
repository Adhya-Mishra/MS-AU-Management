import { HttpErrorResponse } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { ChartDataSets, ChartOptions, ChartType } from 'chart.js';
import { Label } from 'ng2-charts';
import { TrendService } from '../trend/trend.service';

@Component({
  selector: 'app-bar-chart',
  templateUrl: './bar-chart.component.html',
  styleUrls: ['./bar-chart.component.scss']
})
export class BarChartComponent implements OnInit {

  
skills:String[]=[];
location:Location[]=[];
 totalUser:String[]=[];
  selectedParam!: string;

  xParamVal:String[]=[];
  xParamOptions:String[]=['skills','location','totalUser'
]

  
  constructor(private trendService:TrendService){}
  ngOnInit(): void {
    this.selectedParam="location";
 

  }
  barChartOptions: ChartOptions = {
    responsive: true,
    scales: { xAxes: [{}], yAxes: [{}] },
  };
  barChartLabels: any= [];
  barChartType: ChartType = 'bar';
  barChartLegend = true;
  barChartPlugins = [];

  barChartData: ChartDataSets[] = [
    { data: [5], label: 'Opportunity' }
  ];
  onShow(){
    if(this.selectedParam==="skills")
    {
      this.getLabels("skills");
    }else if(this.selectedParam==="location"){
this.getLabels("location");
    }else{
      this.getLabels("totalUser");
    }
  }
  public getLabels(label:String):void{
    this.trendService.getLabels(label).subscribe(
      (respone)=>{
        console.log(respone)
       //this.barChartLabels=respone.name;
        
      },
      (err:HttpErrorResponse)=>{
        alert(err.message);
      }
    );
  }
  
}
