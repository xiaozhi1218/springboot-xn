package com.mtl.code.controller;

import com.mtl.code.mapper.TableMapper;
import com.mtl.code.support.CodeGenerator;
import com.mtl.common.tool.api.R;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("gen")
@Api(value = "代码生成", tags = "代码生成")
public class GeneratorController {

    @Autowired
    private TableMapper tableMapper;

    @GetMapping("getTables")
    @ApiOperation(value = "获取数据库表", notes = "获取数据库表")
    public R<Object> getTables(){
        return R.data(tableMapper.listTable());
    }
    @GetMapping("getTableColumn")
    @ApiOperation(value = "获取表列属性", notes = "获取表列属性")
    public R<Object> getTableColumn(String tableName){
        return R.data(tableMapper.listTableColumn(tableName));
    }
    @GetMapping("codGen")
    @ApiOperation(value = "生成代码", notes = "生成代码")
    public R<Object> codeGenerate(String codeName,String packageName,String[] tables){
        CodeGenerator generator=new CodeGenerator();
        generator.setCodeName(codeName);
        generator.setPackageName(packageName);
        generator.setTablePrefix(new String[]{"mtl_"});
        generator.setIncludeTables(tables);
        // 设置是否继承基础业务字段
        generator.setHasSuperEntity(false);
        String preName=codeName.split("-").length>1? (new StringBuilder()).append(Character.toUpperCase(codeName.split("-")[0].charAt(0))).append(codeName.split("-")[0].substring(1)).toString():"";
        generator.run(preName);
        return R.success("成功！");
    }
}
