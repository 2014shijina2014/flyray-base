$(function () {
    $("#jqGrid").jqGrid({
        url: '../cms/specialColumn/list',
        datatype: "json",
        colModel: [			
			{ label: 'ID', name: 'id', index: "id", width: 45, key: true },
			{ label: '专栏名称', name: 'columnName', width: 75 },
			{ label: '专栏介绍', name: 'columnDesc', width: 90 },
			{ label: '专栏logo', name: 'columnLogo', width: 100 },
            { label: '专栏状态', name: 'columnStatus', width: 80, formatter: function(value, options, row){
                return value !== 1 ?
                    '<span class="label label-danger">禁用</span>' :
                    '<span class="label label-success">正常</span>';
            }},
            { label: '专栏创建者', name: 'createBy', width: 50 }
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
			columnName: null
		},
		showList: true,
		title:null,
		specialColumn:{
			columnName:null,
			columnDesc:null,
			columnLogo:null,
            columnStatus:null,
			createBy:null
		}
	},
	methods: {
		query: function () {
			vm.reload();
		},
		add: function(){
			vm.showList = false;
			vm.title = "新增";
			vm.specialColumn = {
                columnName:null,
                columnDesc:null,
                columnLogo:null,
                columnStatus:null,
                createBy:null
            }
		},
		update: function () {
			var id = getSelectedRow();
			if(id == null){
				return ;
			}
			
			vm.showList = false;
            vm.title = "修改";
			
			vm.getSpecialColumn(id);
		},
		del: function () {
			var ids = getSelectedRows();
			if(ids == null){
				return ;
			}
			
			confirm('确定要删除选中的记录？', function(){
				$.ajax({
					type: "POST",
				    url: "../cms/specialColumn/delete",
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
			var url = vm.specialColumn.id == null ? "../cms/specialColumn/save" : "../cms/specialColumn/update";
			$.ajax({
				type: "POST",
			    url: url,
			    data: JSON.stringify(vm.specialColumn),
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
		getSpecialColumn: function(id){
			$.get("../cms/specialColumn/info/"+id, function(r){
				vm.specialColumn = r.specialColumn;
			});
		},
		reload: function (event) {
			vm.showList = true;
			var page = $("#jqGrid").jqGrid('getGridParam','page');
			$("#jqGrid").jqGrid('setGridParam',{
                postData:{'columnName': vm.q.columnName},
                page:page
            }).trigger("reloadGrid");
		}
	}
});