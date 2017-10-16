
var vm = new Vue({
	el:'#rrapp',
	data:{
		
	},
	mounted:function(){
		// 基于准备好的dom，初始化echarts实例
		var myChart = echarts.init(document.getElementById('main'));

		option = {
			    title : {
			        text: '某地区蒸发量和降水量',
			        subtext: '纯属虚构'
			    },
			    tooltip : {
			        trigger: 'axis'
			    },
			    legend: {
			        data:['蒸发量','降水量']
			    },
			    toolbox: {
			        show : true,
			        feature : {
			            mark : {show: true},
			            dataView : {show: true, readOnly: false},
			            magicType : {show: true, type: ['line', 'bar']},
			            restore : {show: true},
			            saveAsImage : {show: true}
			        }
			    },
			    calculable : true,
			    xAxis : [
			        {
			            type : 'category',
			            data : ['1月','2月','3月','4月','5月','6月','7月','8月','9月','10月','11月','12月']
			        }
			    ],
			    yAxis : [
			        {
			            type : 'value'
			        }
			    ],
			    series : [
			        {
			            name:'蒸发量',
			            type:'bar',
			            data:[2.0, 4.9, 7.0, 23.2, 25.6, 76.7, 135.6, 162.2, 32.6, 20.0, 6.4, 3.3],
			            markPoint : {
			                data : [
			                    {type : 'max', name: '最大值'},
			                    {type : 'min', name: '最小值'}
			                ]
			            },
			            markLine : {
			                data : [
			                    {type : 'average', name: '平均值'}
			                ]
			            }
			        },
			        {
			            name:'降水量',
			            type:'bar',
			            data:[2.6, 5.9, 9.0, 26.4, 28.7, 70.7, 175.6, 182.2, 48.7, 18.8, 6.0, 2.3],
			            markPoint : {
			                data : [
			                    {name : '年最高', value : 182.2, xAxis: 7, yAxis: 183, symbolSize:18},
			                    {name : '年最低', value : 2.3, xAxis: 11, yAxis: 3}
			                ]
			            },
			            markLine : {
			                data : [
			                    {type : 'average', name : '平均值'}
			                ]
			            }
			        }
			    ]
			};

		// 使用刚指定的配置项和数据显示图表。
		myChart.setOption(option);

		var myChart1 = echarts.init(document.getElementById('main1'));
		option1 = {
			    title : {
			        text: '某站点用户访问来源',
			        subtext: '纯属虚构',
			        x:'center'
			    },
			    tooltip : {
			        trigger: 'item',
			        formatter: "{a} <br/>{b} : {c} ({d}%)"
			    },
			    legend: {
			        orient : 'vertical',
			        x : 'left',
			        data:['直接访问','邮件营销','联盟广告','视频广告','搜索引擎']
			    },
			    toolbox: {
			        show : true,
			        feature : {
			            mark : {show: true},
			            dataView : {show: true, readOnly: false},
			            magicType : {
			                show: true, 
			                type: ['pie', 'funnel'],
			                option: {
			                    funnel: {
			                        x: '25%',
			                        width: '50%',
			                        funnelAlign: 'left',
			                        max: 1548
			                    }
			                }
			            },
			            restore : {show: true},
			            saveAsImage : {show: true}
			        }
			    },
			    calculable : true,
			    series : [
			        {
			            name:'访问来源',
			            type:'pie',
			            radius : '55%',
			            center: ['50%', '60%'],
			            data:[
			                {value:335, name:'直接访问'},
			                {value:310, name:'邮件营销'},
			                {value:234, name:'联盟广告'},
			                {value:135, name:'视频广告'},
			                {value:1548, name:'搜索引擎'}
			            ]
			        }
			    ]
			};

		myChart1.setOption(option1);
		
		var myChart2 = echarts.init(document.getElementById('main2'));
		option2 = {
			    title : {
			        text: '某楼盘销售情况',
			        subtext: '纯属虚构'
			    },
			    tooltip : {
			        trigger: 'axis'
			    },
			    legend: {
			        data:['意向','预购','成交']
			    },
			    toolbox: {
			        show : true,
			        feature : {
			            mark : {show: true},
			            dataView : {show: true, readOnly: false},
			            magicType : {show: true, type: ['line', 'bar', 'stack', 'tiled']},
			            restore : {show: true},
			            saveAsImage : {show: true}
			        }
			    },
			    calculable : true,
			    xAxis : [
			        {
			            type : 'category',
			            boundaryGap : false,
			            data : ['周一','周二','周三','周四','周五','周六','周日']
			        }
			    ],
			    yAxis : [
			        {
			            type : 'value'
			        }
			    ],
			    series : [
			        {
			            name:'成交',
			            type:'line',
			            smooth:true,
			            itemStyle: {normal: {areaStyle: {type: 'default'}}},
			            data:[10, 12, 21, 54, 260, 830, 710]
			        },
			        {
			            name:'预购',
			            type:'line',
			            smooth:true,
			            itemStyle: {normal: {areaStyle: {type: 'default'}}},
			            data:[30, 182, 434, 791, 390, 30, 10]
			        },
			        {
			            name:'意向',
			            type:'line',
			            smooth:true,
			            itemStyle: {normal: {areaStyle: {type: 'default'}}},
			            data:[1320, 1132, 601, 234, 120, 90, 20]
			        }
			    ]
			};
		myChart2.setOption(option2);
		
		var myChart3 = echarts.init(document.getElementById('main3'));
		option3 = {
			    title : {
			        text: '漏斗图',
			        subtext: '纯属虚构'
			    },
			    tooltip : {
			        trigger: 'item',
			        formatter: "{a} <br/>{b} : {c}%"
			    },
			    toolbox: {
			        show : true,
			        feature : {
			            mark : {show: true},
			            dataView : {show: true, readOnly: false},
			            restore : {show: true},
			            saveAsImage : {show: true}
			        }
			    },
			    legend: {
			        data : ['展现','点击','访问','咨询','订单']
			    },
			    calculable : true,
			    series : [
			        {
			            name:'漏斗图',
			            type:'funnel',
			            x: '10%',
			            y: 60,
			            //x2: 80,
			            y2: 60,
			            width: '80%',
			            // height: {totalHeight} - y - y2,
			            min: 0,
			            max: 100,
			            minSize: '0%',
			            maxSize: '100%',
			            sort : 'descending', // 'ascending', 'descending'
			            gap : 10,
			            itemStyle: {
			                normal: {
			                    // color: 各异,
			                    borderColor: '#fff',
			                    borderWidth: 1,
			                    label: {
			                        show: true,
			                        position: 'inside'
			                        // textStyle: null      // 默认使用全局文本样式，详见TEXTSTYLE
			                    },
			                    labelLine: {
			                        show: false,
			                        length: 10,
			                        lineStyle: {
			                            // color: 各异,
			                            width: 1,
			                            type: 'solid'
			                        }
			                    }
			                },
			                emphasis: {
			                    // color: 各异,
			                    borderColor: 'red',
			                    borderWidth: 5,
			                    label: {
			                        show: true,
			                        formatter: '{b}:{c}%',
			                        textStyle:{
			                            fontSize:20
			                        }
			                    },
			                    labelLine: {
			                        show: true
			                    }
			                }
			            },
			            data:[
			                {value:60, name:'访问'},
			                {value:40, name:'咨询'},
			                {value:20, name:'订单'},
			                {value:80, name:'点击'},
			                {value:100, name:'展现'}
			            ]
			        }
			    ]
			};
			     
		myChart3.setOption(option3);
	},
	methods: {
		
	}
});