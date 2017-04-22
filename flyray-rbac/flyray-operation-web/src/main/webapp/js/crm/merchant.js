$(function () {
    $("#jqGrid").jqGrid({
        url: '../crm/merchant/list',
        datatype: "json",
        colModel: [			
			{ label: 'ID', name: 'id', index: "id", width: 45, key: true },
			{ label: '商户号', name: 'merchantNo', width: 75 },
			{ label: '机构号', name: 'orgNo', width: 50 },
			{ label: '商户名称', name: 'merchantName', width: 50 },
			{ label: '商户简介', name: 'briefIntro', width: 50 },
			{ label: '商户地址', name: 'merchantAddress', width: 50 },
			{ label: '商户电话', name: 'merchantPhone', width: 50 },
			{ label: '商户logo', name: 'merchantLogo', width: 50 },
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
			merchantNo: null
		},
		showList: true,
		title:null,
		merchant:{
			merchantNo:null,
			orgNo:null,
			merchantName:null,
			briefIntro:null,
			merchantAddress:null,
			merchantPhone:null,
			merchantLogo:null,
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
			
			vm.getMerchant(id);
		},
		del: function () {
			var ids = getSelectedRows();
			if(ids == null){
				return ;
			}
			
			confirm('确定要删除选中的记录？', function(){
				$.ajax({
					type: "POST",
				    url: "../crm/merchant/delete",
				    data: JSON.stringify(orgIds),
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
			var url = vm.merhcant.id == null ? "../crm/merchant/save" : "../crm/merchant/update";
			$.ajax({
				type: "POST",
			    url: url,
			    data: JSON.stringify(vm.merhcant),
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
		getMerchant: function(orgId){
			$.get("../crm/merchant/info/"+id, function(r){
				vm.merhcant = r.merhcant;
			});
		},
		reload: function (event) {
			vm.showList = true;
			var page = $("#jqGrid").jqGrid('getGridParam','page');
			$("#jqGrid").jqGrid('setGridParam',{ 
                postData:{'customerNo': vm.q.customerNo},
                page:page
            }).trigger("reloadGrid");
		}
	}
});