#include "TokensCreator.h"

FILE* output;

void set_output(char* app_name, char* extension)
{
	output = fopen(strcat(app_name, extension), "wb");
}

void end_work()
{
	fclose(output);
}

void writestr(const char* str)
{
	int l = strlen(str);
	putc(l, output);
	for (int i = 0; i < l; i++)
	{
		putc(str[i], output);
	}
}

void set_header(HeaderType h)
{
	putc(h, output);
}

void set_platform(PlatformType p)
{
	putc(p, output);
}
