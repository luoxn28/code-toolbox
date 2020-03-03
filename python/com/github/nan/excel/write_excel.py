import xlwt


def font_format():
    font = xlwt.Font()
    font.colour_index = 2
    # 字体加粗
    font.bold = False
    # 字体下划线
    font.underline = True
    # 斜体字
    font.italic = False
    return font


def write(sheet, row, column, text):
    style0 = xlwt.XFStyle()
    style0.font = font_format()
    sheet.write(row, column, text, style0)


if __name__ == '__main__':
    wb = xlwt.Workbook()
    sheet = wb.add_sheet(u'%s' % '第一个sheet', cell_overwrite_ok=True)
    write(sheet, 0, 0, 'hello world')
    wb.save('demo.xls')
