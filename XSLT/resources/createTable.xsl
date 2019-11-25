<?xml version='1.0'?>
<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform"
								xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
>

<xsl:template match="/">
	<xsl:variable name="tableName">
		<xsl:value-of select="table/@name"/>
	</xsl:variable>
	<xsl:variable name="singleName">
		<xsl:value-of select="substring($tableName,1,string-length($tableName)-1)" />
	</xsl:variable>
	<xsl:element name="{$tableName}">
		<xsl:attribute name="xsi:noNamespaceSchemaLocation"><xsl:value-of select="table/@name"/>.xsd</xsl:attribute>
		<xsl:element name="{$singleName}">
			<xsl:for-each select="/table/column">
				<xsl:variable name="ColumnName">
					<xsl:value-of select="name"/>
				</xsl:variable>
				<xsl:element name="{$ColumnName}"/>
			</xsl:for-each>
		</xsl:element> 
	</xsl:element>
</xsl:template>

</xsl:stylesheet>