$(function () {
    $("#jqGrid").jqGrid({
        url: '../pay/payChannelConfig/list',
        datatype: "json",
        colModel: [			
			{ label: 'ID', name: 'id', index: "id", width: 45, key: true },
			{ label: '支付通道', name: 'payChannelNo', width: 75 },
			{ label: '支付公司', name: 'payCompanyNo', width: 90 },
			{ label: '组织机构', name: 'orgId', width: 75 },
			{ label: '商户号', name: 'merchantId', width: 75 },
			{ label: '支付商户号', name: 'merAccount', width: 75 },
			{ label: '支付商户key', name: 'merKey', width: 75 },
			{ label: '支付商户签名类型', name: 'singType', width: 75 }
        ],
		viewrecords: true,
        height: 385,
        rowNum: 10,
		rowList : [10,30,50],
        rownumbers: true, 
        rownumWidth: 25, 
        autowidth:true,
        multiselect: true,
        pager: "#jqGridPager",
        jsonReader : {
            root: "page.list",
            page: "page.currPage",
            total: "page.totalPage",
            records: "page.totalCount"
        },
        prmNames : {
            page:"page", 
            rows:"limit", 
            order: "order"
        },
        gridComplete:function(){
        	//隐藏grid底部滚动条
        	$("#jqGrid").closest(".ui-jqgrid-bdiv").css({ "overflow-x" : "hidden" }); 
        }
    });
});

var vm = new Vue({
	el:'#rrapp',
	data:{
		q:{
			payChannelNo: null
		},
		showList: true,
		title:null,
		payChannelConfig:{
			payChannelNo:null,
			payCompanyNo:null,
			orgId:null,
			merchantId:null,
			merAccount:null,
			merKey:null,
			singType:null
		}
	},
	methods: {
		query: function () {
			vm.reload();
		},
		add: function(){
			vm.showList = false;
			vm.title = "新增";
		},
		update: function () {
			var id = getSelectedRow();
			if(id == null){
				return ;
			}
			
			vm.showList = false;
            vm.title = "修改";
			
			vm.getPayChannelConfig(id);
		},
		del: function () {
			var ids = getSelectedRows();
			if(ids == null){
				return ;
			}
			
			confirm('确定要删除选中的记录？', function(){
				$.ajax({
					type: "POST",
				    url: "../pay/payChaPayChannelConfig/delete",
				    data: JSON.stringify(ids),
				    success: function(r){
						if(r.code == 0){
							alert('操作成功', function(index){
                                vm.reload();
							});
						}else{
							alert(r.msg);
						}
					}
				});
			});
		},
		saveOrUpdate: function (event) {
			var url = vm.payChannelConfig.id == null ? "../pay/payChannelConfig/save" : "../pay/payChannelConfig/update";
			$.ajax({
				type: "POST",
			    url: url,
			    data: JSON.stringify(vm.payChannelConfig),
			    success: function(r){
			    	if(r.code === 0){
						alert('操作成功', function(index){
							vm.reload();
						});
					}else{
						alert(r.msg);
					}
				}
			});
		},
		getPayChannelConfig: function(id){
			$.get("../pay/payChannelConfig/info/"+id, function(r){
				vm.payChannelConfig = r.payChannelConfig;
			});
		},
		reload: function (event) {
			vm.showList = true;
			var page = $("#jqGrid").jqGrid('getGridParam','page');
			$("#jqGrid").jqGrid('setGridParam',{ 
                postData:{'orgName': vm.q.orgName},
                page:page
            }).trigger("reloadGrid");
		}
	}
});